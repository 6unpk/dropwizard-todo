package common

data class PageableResponse<T>(
      override val limit: Int,
      override val offset: Int,
      override val result: List<T>
): Pageable<T>
