package net.wadidaw.newsapp.repository

import androidx.room.Query
import net.wadidaw.newsapp.api.RetrofitInstance
import net.wadidaw.newsapp.db.ArticleDatabase
import net.wadidaw.newsapp.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}