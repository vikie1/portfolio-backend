const url =
  "https://api.cloudinary.com/v1_1/dywei4oex/image/upload";
handleFileSubmit = (e) => {
  e.preventDefault();

  const files = document.querySelector("#fileu").files;
  const formData = new FormData();

  document.getElementById("data").innerHTML = "please wait...";
  for (let i = 0; i < files.length; i++) {
    let file = files[i];
    formData.append("file", file);
    formData.append("folder", "betterdevs");
    formData.append("upload_preset", "owbjsdvf");

    fetch(url, {
      method: "POST",
      body: formData,
    })
      .then((response) => {
        return response.text();
      })
      .then((data) => {
        const result = JSON.parse(data);
        const imageUrl = document.getElementById("imgURL");
        imageUrl.value = result.secure_url;
        document.getElementById("data").innerHTML = "Done uploading";
      });
  }
};

