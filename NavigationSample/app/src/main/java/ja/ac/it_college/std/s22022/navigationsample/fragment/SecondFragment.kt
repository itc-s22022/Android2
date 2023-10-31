package ja.ac.it_college.std.s22022.navigationsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import ja.ac.it_college.std.s22022.navigationsample.R
import ja.ac.it_college.std.s22022.navigationsample.databinding.FragmentSecondBinding

/**
 * 2番目の画面用フラグメント
 */
class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.choice1.setOnClickListener { toNext(1) }
        binding.choice2.setOnClickListener { toNext(2) }
        binding.choice3.setOnClickListener { toNext(3) }
        binding.choice4.setOnClickListener { toNext(4) }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
    private fun toNext(choice: Int) {
        val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(choice)
        findNavController().navigate(action)
    }
}