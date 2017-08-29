export const constants = {
  getApi() {
    let host = window.location.hostname;
    let api = undefined;

    switch (host) {
      case "172.17.0.3":
        api = "http://172.17.0.3:8080/api/v1"; // testing container
        break;
      case "localhost":
        api = "http://localhost:8080/api/v1"; // local dev
        break;
      case "criprj":
        api = "http://criprj:11010/api/v1"; // testing
        break;
      default:
        api = "http://gift-demo.herokuapp.com/api/v1"; // cloud
    }
    return api;
  },

  Website: 'http://172.17.0.3:8080/#'
}

export default constants;