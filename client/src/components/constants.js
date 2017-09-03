export const constants = {
  getApi() {
    return this.determineApiURL(window);
  },

  // Where will e2e tests run?
  Website: 'http://criprj:11010/#', // targeting the testing environment
  // Website: 'http://localhost:4090/#', // from my PC using my dev website

  determineApiURL(window) {
    const location = window.location;
    const host = location.hostname;
    const port = location.port;

    let api = undefined;
    switch (host + ":" + port) {
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
  }
}

export default constants;