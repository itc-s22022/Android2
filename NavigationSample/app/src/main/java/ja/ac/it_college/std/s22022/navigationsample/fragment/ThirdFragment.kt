package ja.ac.it_college.std.s22022.navigationsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ja.ac.it_college.std.s22022.navigationsample.R
import ja.ac.it_college.std.s22022.navigationsample.databinding.FragmentThirdBinding

/**
 * 3つ目の画面用のフラグメント。値を受け取る予定
 */
class ThirdFragment : Fragment() {
   private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val args: ThirdFragmentArgs by navArgs() // 委譲プロパティ


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.display.text = "<${args.choice}>"
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}