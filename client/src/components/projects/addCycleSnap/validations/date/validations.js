const validations = {
  isValid(text) {
    let aDate = new Date(text + "T18:00");

    // it is a date
    if (isNaN(aDate.getTime())) {  // d.valueOf() could also work
      // date is not valid
      return false;
    }
    else {
      // date is valid
      let dateReg = /^\d{4}\-\d{2}\-\d{2}$/;
      if (dateReg.test(text)) {
        return true;
      }
      else {
        return false;
      }
    }
  }
}

export default validations;