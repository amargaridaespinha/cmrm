# Data Model

## CatImage

Represents one image returned by The Cat API.

Fields:
- id: String
- url: String
- width: Int
- height: Int

The most important field is url, because it is used to load the image in the RecyclerView.