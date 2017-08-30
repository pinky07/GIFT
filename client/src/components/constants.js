export const constants = {
  getApi() {
    let host = window.location.hostname;
    let port = window.location.port;
    let api = undefined;

    switch (host + ":" + port) {
      case "172.17.0.9:8080":
        api = "http://172.17.0.9:8080/api/v1"; // testing container
        break;
      case "localhost:4090":
        api = "http://localhost:8080/api/v1"; // local dev
        break;
      case "criprj:11010":
        api = "http://criprj:11010/api/v1"; // testing
        break;
      default:
        api = "http://gift-demo.herokuapp.com/api/v1"; // cloud
    }
    return api;
  },

  // Where will e2e tests run?
   Website: 'http://172.17.0.9:8080/#' // inside the ci server
  // Website: 'http://criprj:11010/#' // from my PC using the testing site
  // Website: 'http://localhost:4090/#' // from my PC using my dev website
}

export default constants;