package com.naim.starwars.ui.tripdetail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.kodein
import com.github.salomonbrys.kodein.with
import com.naim.starwars.MainActivity
import com.naim.starwars.R
import com.naim.starwars.ui.model.ViewTripDetailModel
import com.naim.starwars.ui.mvpekino.MvpKodeinFragment
import kotlinx.android.synthetic.main.fragment_trip_detail.arrival
import kotlinx.android.synthetic.main.fragment_trip_detail.arrival_time
import kotlinx.android.synthetic.main.fragment_trip_detail.departure
import kotlinx.android.synthetic.main.fragment_trip_detail.departure_time
import kotlinx.android.synthetic.main.fragment_trip_detail.detail_pilot_name
import kotlinx.android.synthetic.main.fragment_trip_detail.distance
import kotlinx.android.synthetic.main.fragment_trip_detail.duration
import kotlinx.android.synthetic.main.fragment_trip_detail.pilot_avatar
import kotlinx.android.synthetic.main.fragment_trip_detail.rating_empty
import kotlinx.android.synthetic.main.fragment_trip_detail.star_1
import kotlinx.android.synthetic.main.fragment_trip_detail.star_2
import kotlinx.android.synthetic.main.fragment_trip_detail.star_3
import kotlinx.android.synthetic.main.fragment_trip_detail.star_4
import kotlinx.android.synthetic.main.fragment_trip_detail.star_5
import java.text.DecimalFormat
import java.text.SimpleDateFormat

/**
 * TripDetailFragment -
 *
 * @author naim
 * @version $Id$
 */
class TripDetailFragment
    : MvpKodeinFragment<TripDetailContract.Presenter>(), TripDetailContract.View {

    override val defaultLayout: Int = R.layout.fragment_trip_detail

    override val presenter: TripDetailContract.Presenter by lazy {
        kodein().value
                .with(arguments?.getInt(KEY_ID))
                .instance<TripDetailContract.Presenter>()
    }

    companion object {
        private const val KEY_ID = "tripid"

        fun newInstance(id: Int): TripDetailFragment {
            val bundle = Bundle()
            bundle.putInt(KEY_ID, id)
            return TripDetailFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun setData(trip: ViewTripDetailModel) {
        detail_pilot_name.text = trip.pilotName

        val formatStringToDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val formatDateToDisplayTime = SimpleDateFormat("h:mm a")

        // Departure
        departure.text = trip.pickupName
        val pickupDate = formatStringToDate.parse(trip.pickupTime)
        val pickupHour = formatDateToDisplayTime.format(pickupDate)
        departure_time.text = pickupHour

        // Arrival
        arrival.text = trip.dropoffName
        val dropoffDate = formatStringToDate.parse(trip.dropoffTime)
        val dropoffHour = formatDateToDisplayTime.format(dropoffDate)
        arrival_time.text = dropoffHour

        // Distance
        val formatter = DecimalFormat("#,###,###") // TODO : trouver autre chose
        val formattedDistance = formatter.format(trip.distance)
        distance.text = resources.getString(R.string.distance_value, formattedDistance, trip.distanceUnit)

        // Duration
        val formatterDuration = SimpleDateFormat("h:mm:ss")
        val diff = dropoffDate.time - pickupDate.time
        duration.text = formatterDuration.format(diff)

        // Rating
        val ratingRounded = Math.round(trip.rating)
        if (ratingRounded < 1) {
            rating_empty.visibility = View.VISIBLE
        }
        // TODO set star1,2,3,4,5 avec id ressource

        if (ratingRounded == 4) {
            star_1.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.star_filled))
            star_2.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.star_filled))
            star_3.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.star_filled))
            star_4.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.star_filled))
            star_5.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.star_empty))
        }

        Glide.with(requireContext())
                // TODO
                .load(resources.getString(R.string.base_url) + trip.pilotAvatar)
                .into(pilot_avatar)
    }


    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun setLoadingState(isLoading: Boolean) {
        (activity as MainActivity).setLoadingState(isLoading)
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<TripDetailContract.View>() with instance(this@TripDetailFragment)
    }

}
