package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class EventDTO(
    val characters: CharactersDTO,
    val comics: ComicsDTO,
    val creators: CreatorsDTO,
    val description: String,
    val end: String,
    val id: String,
    val modified: String,
    val next: NextDTO,
    val previous: PreviousDTO,
    val resourceURI: String,
    val series: SeriesDTO,
    val start: String,
    val stories: StoriesDTO,
    val thumbnail: ThumbnailDTO,
    val title: String,
    val urls: List<UrlDTO>
)