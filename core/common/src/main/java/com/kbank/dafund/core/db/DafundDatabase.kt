package com.kbank.dafund.core.db

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kbank.dafund.core.BuildConfig
import net.sqlcipher.database.SupportFactory
import javax.crypto.KeyGenerator

const val DATABASE_NAME = "dafund_database.db"
const val PREFS_KEY_PASSPHRASE = "PREFS_KEY_PASSPHRASE"
const val ALGORITHM_AES = "AES"
const val KEY_SIZE = 256

// ref https://github.com/Lenz-K/android-encrypted-room-database-example
@Database(entities = [Employee::class], version = 1)
abstract class DafundDatabase : RoomDatabase() {

    abstract val databaseDao: DafundDatabaseDao

    companion object {
        /**
         * Creates a database instance and returns it.
         */
        fun createDB(context: Context, sharedPreferences: SharedPreferences): DafundDatabase {
            val database = Room.databaseBuilder(
                context.applicationContext,
                DafundDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration()
            if (!BuildConfig.DEBUG) {
                val passphrase = getPassphrase(sharedPreferences) ?: initializePassphrase(sharedPreferences)
                val factory = SupportFactory(passphrase)
                database.openHelperFactory(factory)
            }
            return database.build()
        }

        /**
         * Generates a passphrase and stores it in the encrypted shared preferences.
         * Returns the newly generated passphrase.
         */
        private fun initializePassphrase(sharedPreferences: SharedPreferences): ByteArray {
            val passphrase = generatePassphrase()
            sharedPreferences.edit(commit = true) {
                putString(PREFS_KEY_PASSPHRASE, passphrase.toString(Charsets.ISO_8859_1))
            }

            return passphrase
        }

        /**
         * Retrieves the passphrase for encryption from the encrypted shared preferences.
         * Returns null if there is no stored passphrase.
         */
        private fun getPassphrase(sharedPreferences: SharedPreferences): ByteArray? {
            val passphraseString = sharedPreferences.getString(PREFS_KEY_PASSPHRASE, null)
            return passphraseString?.toByteArray(Charsets.ISO_8859_1)
        }

        /**
         * Generates and returns a passphrase.
         */
        private fun generatePassphrase(): ByteArray {
            val keyGenerator = KeyGenerator.getInstance(ALGORITHM_AES)
            keyGenerator.init(KEY_SIZE)
            return keyGenerator.generateKey().encoded
        }
    }
}
