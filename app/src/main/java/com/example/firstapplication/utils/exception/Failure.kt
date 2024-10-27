package com.example.firstapplication.utils.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    abstract class FeatureFailure : Failure()
}
