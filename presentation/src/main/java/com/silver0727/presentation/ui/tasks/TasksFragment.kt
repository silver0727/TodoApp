package com.silver0727.presentation.ui.tasks

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.silver0727.presentation.R
import com.silver0727.presentation.databinding.TasksFragmentBinding

/**
 * 작업 목록 페이지
 */
@AndroidEntryPoint
class TasksFragment : Fragment() {

    private var _binding: TasksFragmentBinding? = null
    private val binding get() = _binding

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {

    private fun setupObservers() {
    }

    }
}