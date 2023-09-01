package com.curso.android.app.practica.pairstring

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.pairstring.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest{
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val text1 = viewModel.pairString.value?.string1
        val text2 = viewModel.pairString.value?.string2
        assertEquals("", text1)
        assertEquals("", text2)
    }

    @Test
    fun mainViewModel_TestAsignarParStr() = runTest {
        val text1 = "Texto1 de prueba"
        val text2 = "Texto1 de prueba"
        launch {
            viewModel.asignStrings(text1, text2)
        }
        advanceUntilIdle()
        assertEquals(text1, viewModel.pairString.value?.string1)
        assertEquals(text2, viewModel.pairString.value?.string2)
    }

    @Test
    fun mainViewModel_TestCompararParStrIguales() = runTest {
        launch {
            viewModel.asignStrings("mismo texto", "mismo texto")
        }
        advanceUntilIdle()
        val result = viewModel.comparePairStr()
        assertEquals(result, true)
    }

    @Test
    fun mainViewModel_TestCompararParStrDistintos() = runTest {
        launch {
            viewModel.asignStrings("distintos 1", "distintos 2")
        }
        advanceUntilIdle()
        val result = viewModel.comparePairStr()
        assertEquals(result, false)
    }
}
