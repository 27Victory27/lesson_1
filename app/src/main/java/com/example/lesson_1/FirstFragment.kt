package com.example.lesson_1

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.lesson_1.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var sum = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            sum += 1
            binding.textviewFirst.text = sum.toString()
        }
        binding.buttonFirst1.setOnClickListener {
            sum += 2
            binding.textviewFirst.text = sum.toString()
        }
        binding.buttonFirst2.setOnClickListener {
            sum += 3
            binding.textviewFirst.text = sum.toString()
        }

// определяем строковый массив

// определяем строковый массив
        val catNames = arrayOf(
            "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
            "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
            "Китти", "Масяня" , "Барсик", "Мурзик", "Мурка", "Васька",
            "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
            "Китти", "Масяня", "Fill","Roman","JoJo"
        )

// используем адаптер данных

// используем адаптер данных
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            R.layout.simple_list_item_1, catNames
        )
        binding.listView.setAdapter(adapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}