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
import com.naim.starwars.ui.model.TripDetailViewModel
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

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).setBackActionBar()
    }

    override fun setData(trip: TripDetailViewModel) {
        // Pilot
        detail_pilot_name.text = trip.pilotName
        Glide.with(requireContext())
                .load(trip.pilotAvatar)
                .into(pilot_avatar)

        // Departure
        departure.text = trip.departureName
        departure_time.text = trip.departureTime

        // Arrival
        arrival.text = trip.arrivalName
        arrival_time.text = trip.arrivalTime

        // Distance
        distance.text = resources.getString(
                R.string.distance_value, trip.distanceValue, trip.distanceUnit)

        // Duration
        duration.text = trip.duration

        // Rating
        if (trip.rating < 1) {
            rating_empty.visibility = View.VISIBLE
        } else {
            star_1.setImageDrawable(ContextCompat.getDrawable(requireContext(), trip.starListResId[0]))
            star_2.setImageDrawable(ContextCompat.getDrawable(requireContext(), trip.starListResId[1]))
            star_3.setImageDrawable(ContextCompat.getDrawable(requireContext(), trip.starListResId[2]))
            star_4.setImageDrawable(ContextCompat.getDrawable(requireContext(), trip.starListResId[3]))
            star_5.setImageDrawable(ContextCompat.getDrawable(requireContext(), trip.starListResId[4]))
        }
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
