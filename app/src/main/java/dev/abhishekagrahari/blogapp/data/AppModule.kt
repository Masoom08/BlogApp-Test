package dev.abhishekagrahari.blogapp.data



import android.content.Context
import androidx.room.Room
import dev.abhishekagrahari.blogapp.data.local.AppDatabase
import dev.abhishekagrahari.blogapp.data.repository.ItemRepository

object AppModule {
    private var database: AppDatabase? = null

    fun provideDatabase(context: Context): AppDatabase {
        if (database == null) {
            database = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
        }
        return database!!
    }

    fun provideItemRepository(context: Context): ItemRepository {
        val dao = provideDatabase(context).itemDao()
        return ItemRepository(dao)
    }
}
