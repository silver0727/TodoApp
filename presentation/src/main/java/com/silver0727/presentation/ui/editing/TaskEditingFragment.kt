package com.silver0727.presentation.ui.editing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.silver0727.presentation.databinding.TaskEditingFragmentBinding
import com.silver0727.presentation.ui.main.ADD_EDIT_RESULT_OK
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskEditingFragment : Fragment() {

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
        setupObservers()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        mViewModel.taskUpdatedEvent.observe(viewLifecycleOwner) { event ->
            event ?: return@observe
            val action = TaskEditingFragmentDirections.actionTaskEditingFragmentToTasksFragment(
                ADD_EDIT_RESULT_OK
            )
            findNavController().navigate(action)
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