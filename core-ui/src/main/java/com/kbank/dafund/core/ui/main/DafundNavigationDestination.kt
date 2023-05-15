package com.kbank.dafund.core.ui.main

interface DafundNavigationDestination {
    /**
     * Route is a String that defines the path to your composable.
     * Each destination should have a unique route.
     */
    val route: String

    /**
     * Defines a specific destination ID.
     * This is needed when using nested graphs to differentiate a specific
     * destination's route from the route of the entire nested graph it belongs to.
     */
    val destination: String
}
