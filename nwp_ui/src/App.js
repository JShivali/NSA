import React from "react";

import "./App.css";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
import { Link } from "react-router";
import { BrowserRouter as Router, Route } from "react-router-dom";
import { FacebookLoginButton } from "react-social-login-buttons";
import Login from "./Components/Login";
import Register from "./Components/Register";
import Dashboard from "./Components/Dashboard";

function App() {
  var cors = require("cors");

  return (
    // <Form className="landing-page">
    //   <h1>Numerical Weather Prediction Portal</h1>
    //   <FormGroup>
    //     <Button className="btn-lg btn-dark btn-block" onClick={Login}>
    //       <Route path="/" component={Login} />
    //     </Button>
    //   </FormGroup>
    //   <Button className="btn-lg btn-dark btn-block">Register</Button>
    // </Form>
    <Router>
      <div>
        <Route path="/" component={Login} exact />
      </div>
    </Router>
  );
}

export default App;
