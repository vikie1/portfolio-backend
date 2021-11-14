submitBlog = e => {
    e.preventDefault()

    const url = "/api/betterdevs/blog"
    const name = document.getElementById("name").value
    const description = document.getElementById("desc").value
    const link = document.getElementById("link").value
    const imgURL = document.getElementById("imgURL").value
    const topics = document.getElementById("topics").value.split(",")
    const data = {name, imgURL, description, link, topics}
    fetch(url, {
        headers: {
            "content-type": "application/json"
        },
        method:"POST",
        body:JSON.stringify(data)
    }).then(() => {
        document.getElementById("success").innerHTML = "Done uploading";
    })
}