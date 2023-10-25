package ja.ac.it_college.std.s22022.navigationsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}