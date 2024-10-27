package com.croem.daim.core.interactor


import com.example.firstapplication.utils.exception.Failure
import com.example.firstapplication.utils.functional.Either
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
               run(params)
            }
            onResult(deferred.await())
        }
    }
}
