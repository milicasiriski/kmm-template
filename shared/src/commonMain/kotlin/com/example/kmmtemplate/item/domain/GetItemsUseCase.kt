package com.example.kmmtemplate.item.domain

import com.example.kmmtemplate.util.Either
import com.example.kmmtemplate.util.right
import kotlin.random.Random

class GetItemsUseCase {
    operator fun invoke(): Either<GetItemsError, List<Item>> {
        val result = mutableListOf<Item>()

        for (i in 0..100) {
            val item = Item(
                id = "$i",
                description = "This is item $i",
                param = Random.nextInt(),
                optionalParam = if (Random.nextBoolean()) Random.nextInt() else null
            )
            result.add(item)
        }

        return result.right()
    }
}

data object GetItemsError