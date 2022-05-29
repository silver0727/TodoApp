package com.silver0727.presentation.ui.editing

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.silver0727.presentation.R
import com.silver0727.presentation.databinding.TaskEditingFragmentBinding
import com.silver0727.presentation.ui.main.ADD_EDIT_RESULT_OK
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaskEditingFragment : Fragment() {

    private val taskEditingFragmentArgs by navArgs<TaskEditingFragmentArgs>()
    private var _binding: TaskEditingFragmentBinding? = null
    private val binding get() = _binding

    private val mViewModel by viewModels<TaskEditingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TaskEditingFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@TaskEditingFragment
            viewModel = mViewModel
        }
        setHasOptionsMenu(true)
        setupObservers()
        return binding?.root
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.menu_register -> {
                true
            }
            else -> false
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_task_editing_fragment, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.fetchTaskById(taskEditingFragmentArgs.taskId)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {

        lifecycleScope.launch {
            mViewModel.task
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect { task ->
                    task ?: return@collect
//                    binding?.etContent?.setText(task.description)
                }

            mViewModel.taskUpdatedEvent
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.RESUMED)
                .collect { event ->
                    event ?: return@collect
                    val action = TaskEditingFragmentDirections.actionTaskEditingFragmentToTasksFragment(
                        ADD_EDIT_RESULT_OK
                    )
                    findNavController().navigate(action)
                }
        }
    }

    private fun initView() {
        with(binding) {
            this ?: return@with
            btnComplete.setOnClickListener {
                mViewModel.insertTask(
                    etTitle.text.toString(),
                    etContent.text.toString()
                )
            }
        }
    }

}