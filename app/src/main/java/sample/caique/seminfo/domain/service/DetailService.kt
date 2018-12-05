package sample.caique.seminfo.domain.service

import sample.caique.seminfo.domain.Result
import sample.caique.seminfo.response.Issues

interface DetailService {

    fun detail(result: Result<Issues>)
}