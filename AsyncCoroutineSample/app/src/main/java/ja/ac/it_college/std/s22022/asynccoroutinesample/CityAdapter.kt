package ja.ac.it_college.std.s22022.asynccoroutinesample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ja.ac.it_college.std.s22022.asynccoroutinesample.databinding.RowBinding

class CityAdapter(val callback: (City) -> Unit) : RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    class ViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = cityList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.apply {
            text = cityList[position].name
            setOnClickListener {
                callback(cityList[position])
            }
        }
    }


}