package com.silver0727.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.silver0727.presentation.R
import com.silver0727.presentation.databinding.TaskDetailFragmentBinding
import com.silver0727.presentation.utils.NavigationHandler

class TaskDetailFragment : Fragment(), View.OnClickListener {

    private var _binding: TaskDetailFragmentBinding? = null
    private val binding get() = _binding
    private val detailFragmentArgs by navArgs<TaskDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TaskDetailFragmentBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnEdit?.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_edit -> {
                NavigationHandler.navigateSafe(
                    fragment = this,
                    TaskDetailFragmentDirections.taskDetailFragmentToTaskEditingFragment(
                        taskId = detailFragmentArgs.taskId,
                        title = detailFragmentArgs.title
                    )
                )
            }
        }
    }

}