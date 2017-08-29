export const constants = {
  getApi(){
    let host = window.location.hostname;
    if (host == "172.17.0.3"){
      console.log("host: " + host);
      return "http://172.17.0.3:8080/api/v1"
    }
    else{

      if (host == "localhost"){
        console.log("host: " + host);
        return "http://localhost:8080/api/v1"
      }
      else {
        return "http://criprj:11010/api/v1";
      }
    }
  },
  // API: 'http://localhost:8080/api/v1',
    API: 'http://criprj:11010/api/v1',
  // API: 'http://gift-demo.herokuapp.com/api/v1'

  Website: 'http://172.17.0.3:8080/#'
}

export default constants;