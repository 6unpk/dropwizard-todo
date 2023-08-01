package common

interface Pageable<T> {
    val limit: Int
    val offset: Int
    val result: List<T>
}