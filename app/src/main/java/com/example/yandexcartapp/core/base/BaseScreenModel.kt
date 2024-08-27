package com.example.yandexcartapp.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

abstract class BaseScreenModel<State : Any, Event : Any>(initState: State) : ViewModel(),
    KoinComponent {

    private val ioScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    private val _state = MutableStateFlow(initState)
    val state = _state.asStateFlow()

    private val _event = Channel<Event>(Channel.BUFFERED)
    val event = _event.receiveAsFlow()

    private val _status = MutableStateFlow(false)
    val status = _status.asStateFlow()


    protected fun setState(state: () -> State) {
        _state.value = state()
    }

    protected fun setEvent(newEvent: Event) {
        viewModelScope.launch {
            _event.send(newEvent)
        }
    }

    protected fun setStatus(status: Boolean) {
        viewModelScope.launch {
            _status.value = status
        }
    }

    protected fun <T> launchOperation(
        operation: suspend () -> T,
        success: (T) -> Unit = {},
        loading: (Boolean) -> Unit = { setStatus(it) }
    ) {
        loading.invoke(true)
        viewModelScope.launch {
            success(withContext(ioScope.coroutineContext) {
                operation()
            })
        }
        loading.invoke(false)
    }

}