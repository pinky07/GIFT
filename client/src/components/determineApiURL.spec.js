import constants from './constants';

describe('constants.determineApiURL', () => {

  let window;
  let actual;
  let expected;

  it('should get API for testing', () => {
    window = { location: { hostname: "criprj", port: 11010} };
    actual = constants.determineApiURL(window);
    expected = "http://criprj:11010/api/v1";

    expect(actual).toEqual(expected);
  });

  it('should get API for local development', () => {
    window = { location: { hostname: "localhost", port: 4090} };
    actual = constants.determineApiURL(window);
    expected = "http://localhost:8080/api/v1";

    expect(actual).toEqual(expected);
  });

  it('should get API for local cloud site', () => {
    window = { location: { hostname: "gift-demo.herokuapp.com", port: 80} };
    actual = constants.determineApiURL(window);
    expected = "http://gift-demo.herokuapp.com/api/v1";

    expect(actual).toEqual(expected);
  });
});