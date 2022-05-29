package com.silver0727.presentation.ui.tasks

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.silver0727.presentation.R
import com.silver0727.presentation.databinding.TasksFragmentBinding
import com.silver0727.presentation.model.navigation.NavigationDestination
import com.silver0727.presentation.utils.NavigationHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * 작업 목록 페이지
 */
@AndroidEntryPoint
class TasksFragment : Fragment() {

    private var _binding: TasksFragmentBinding? = null
    private val binding get() = _binding

    private lateinit var tasksAdapter: TasksAdapter

    private val mViewModel: TasksViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TasksFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mViewModel
        }
        setHasOptionsMenu(true)
        setupObservers()
        return binding?.root
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.menu_clear -> {
                true
            }
            R.id.menu_filter -> {
                true
            }
            R.id.menu_refresh -> {
                true
            }
            else -> false
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_tasks_fragment, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        mViewModel.fetchTasks()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {
        tasksAdapter = TasksAdapter()
        with(binding) {
            this ?: return@with
            rvTasks.adapter = tasksAdapter
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            mViewModel.navigationDestination.collect { event ->
                navigateFragment(event ?: return@collect)
            }
        }

        mViewModel.tasks.observe(viewLifecycleOwner) {
            Timber.d("tasks ${it.size}")
        }
    }

    private fun navigateFragment(event: NavigationDestination) {
        when(event) {
            is NavigationDestination.AddTask -> {
                NavigationHandler.navigateSafe(
                    fragment = this,
                    direction = TasksFragmentDirections.actionTasksFragmentToTaskEditingFragment()
                )
            }
            is NavigationDestination.TaskDetail -> {
                NavigationHandler.navigateSafe(
                    fragment = this,
                    direction = TasksFragmentDirections.actionTasksFragmentToTaskDetailFragment(
                        taskId = event.taskId,
                        title = event.title
                    )
                )
            }
            else -> {
                Timber.v("undefined navigation")
            }
        }
    }
}