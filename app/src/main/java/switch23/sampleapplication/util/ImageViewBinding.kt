package switch23.sampleapplication.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUrl")
fun ImageView.loadImage(imageUrl: String) {
    if (imageUrl.isNotEmpty()) {
        Picasso.get().load(imageUrl)
            .fit()
            .into(this)
    }
}
