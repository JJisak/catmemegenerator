// // script.js
//
// function goBack() {
//     window.history.back();
// }
//
// function decodeBase64Image(base64Image) {
//     var imageBlob = base64ToBlob(base64Image);
//     var imageUrl = URL.createObjectURL(imageBlob);
//
//
//     var link = document.createElement('a');
//     link.href = imageUrl;
//     link.download = 'meme.jpg';
//
//
//     link.click();
//
//
//     URL.revokeObjectURL(imageUrl);
//
//     console.log('Meme saved successfully!');
// }
//
// function base64ToBlob(base64Data) {
//     var byteString = atob(base64Data);
//     var mimeString = 'image/jpeg';
//     var ab = new ArrayBuffer(byteString.length);
//     var ia = new Uint8Array(ab);
//     for (var i = 0; i < byteString.length; i++) {
//         ia[i] = byteString.charCodeAt(i);
//     }
//     return new Blob([ab], { type: mimeString });
// }
//
// function saveGeneratedMeme() {
//     var generatedMeme = document.getElementById('generated-meme');
//     decodeBase64Image(generatedMeme.src.replace('data:image/jpeg;base64,', ''));
// }
