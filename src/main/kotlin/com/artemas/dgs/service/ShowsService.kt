package com.artemas.dgs.service

import com.artemas.dgs.data.ShowsDataFetcher
import com.artemas.dgs.domain.Show
import org.springframework.stereotype.Service

@Service
class ShowsService {
    fun shows(): List<Show> {
        return listOf(
            Show("Stranger Things", 2016),
            Show("Ozark", 2017),
            Show("The Crown", 2016),
            Show("Dead to Me", 2019),
            Show("Orange is the New Black", 2013)
        )
    }
}