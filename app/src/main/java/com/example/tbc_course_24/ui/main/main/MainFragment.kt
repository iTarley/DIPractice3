package com.example.tbc_course_24.ui.main.main


import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tbc_course_24.common.Resource
import com.example.tbc_course_24.databinding.FragmentMainBinding
import com.example.tbc_course_24.ui.main.adapter.ActiveRecycler
import com.example.tbc_course_24.ui.main.adapter.NewRecycler
import com.example.tbc_course_24.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {



    private val viewModel: MainViewModel by viewModels()

    private val adapterActive by lazy {
        ActiveRecycler()
    }
    private val adapterNew by lazy {
        NewRecycler()
    }


    override fun start() {

        viewModel.getCourses()

        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.course.collect{
                    adapterActive.submitList(it.activeCourses)
                    adapterNew.submitList(it.newCourses)
                }

            }
        }

    }

    override fun initRecycler() {
        binding?.activeRecycler?.adapter = adapterActive
        binding?.newRecycler?.adapter = adapterNew
    }
}