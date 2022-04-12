const handleSubmit = e => {
    e.preventDefault() //prevent submit attempt

    //get all the data we need
    const name = document.getElementById('typeMusicX').value;
    const artist = document.getElementById('typeArtistX').value;
    const rawLink = document.getElementById('typeLinkX').value;
    const pathName = new URL(rawLink).pathname;

    //prepare data for storage
    const musicUrl = "https://www.youtube.com/embed/" + pathName;
    const data = {name, artist, musicUrl};
    const url = '/api/music/';

    //send data to server
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(() => {
        document.getElementById("success").innerHTML = "Done uploading";
    });
}