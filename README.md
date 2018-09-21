# Simple RecyclerView
[![Download](https://api.bintray.com/packages/tomasznajda/simple-recyclerview/simple-recyclerview/images/download.svg?version=1.1.0) ](https://bintray.com/tomasznajda/simple-recyclerview/simple-recyclerview/1.1.0/link) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SimpleRecyclerView-green.svg?style=flat)](https://android-arsenal.com/details/1/7111) [![CircleCI](https://circleci.com/gh/tomasznajda/simple-recyclerview.svg?style=svg)](https://circleci.com/gh/tomasznajda/simple-recyclerview)\
This library is created to simplify usage of the RecyclerView with multiple ViewHolders.

## Dependency
```groovy
dependencies {
    implementation "com.tomasznajda.simplerecyclerview:simplerecyclerview:1.1.0"
}
```

## Usage

For example we are using two simple entities: User and Advertisement. 
```kotlin
data class User(val name: String)
data class Advertisement(val url: String)
```

Of course we want to show them on the list. So... we need to create ViewHolders for them.
```kotlin
class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SrvViewHolder<User> {
    override fun bind(item: User) {
        itemView.title.text = item.name
    }
}
class AdvertisementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SrvViewHolder<Advertisement> {
    override fun bind(item: Advertisement) {
        itemView.ad.text = item.url
    }
}
```
### BasicSrvAdapter
BasicSrvAdapter offers only setting list of items. If we want to do some other operation (replace, remove, add, move, etc.), we have to get the current list from adapter, do an operation on that list and set new list. `notifyDataSetChanged()` will be invoked automatically after setting the list.

##### Initialize adapter
```kotlin
val adapter = BasicSrvAdapter().apply {
    addViewHolder(User::class, R.layout.viewholder_user) { UserViewHolder(it) }
    addViewHolder(Advertisement::class, R.layout.viewholder_ad) { AdvertisementViewHolder(it) }
}
recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = adapter
```

##### Manipulate displayed items
```kotlin
adapter.items = listOf(
        User("FirstUser 1"),
        Advertisement("http://advertisement.com/1"),
        User("FirstUser 2")
)
//without notifyDataSetChanged()
```

### AdvancedSrcAdapter

AdvancedSrcAdapter offers advanced operations like:
- set items
- insert single item (at the specified position or at the end of the list)
- insert list of items (at the specified position or at the end of the list)
- remove single item (with specified position or item)
- move item to a new position (with specified current position or item)
- replace item at the specified position



##### Initialize adapter
```kotlin
val adapter = AdvancedSrvAdapter().apply {
    addViewHolder(User::class, R.layout.viewholder_user) { UserViewHolder(it) }
    addViewHolder(Advertisement::class, R.layout.viewholder_ad) { AdvertisementViewHolder(it) }
}

recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = adapter
```

##### Manipulate displayed items
```kotlin
adapter.set(listOf(User("name 1"), Advertisement("ad 1"))) //without notifyDataSetChanged()
adapter.insert(User("name 2"), position = 1) //without notifyItemInserted()
adapter.insert(listOf(User("name 2"), User("name 3")), position = 1) //without notifyItemRangeInserted()
adapter.remove(User("name 1")) //without notifyItemRemoved()
adapter.remove(0) //without notifyItemRemoved()
adapter.move(0, 1) //without notifyItemMoved()
adapter.replace(User("name 99"), 0) //without notifyItemChanged()
```

