function nowPlaying(arr){
    let trackName = arr[0];
    let artist = arr[1];
    let duration = arr[2];
    console.log(`Now Playing: ${artist} - ${trackName} [${duration}]`);
}

nowPlaying(['Number One', 'Nelly', '4:09'])