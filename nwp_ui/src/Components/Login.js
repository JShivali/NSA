import React from "react";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";

import { FacebookLoginButton } from "react-social-login-buttons";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import axios from "axios";
import App from "../App";

class Login extends React.Component {
  state = {
    userName: "Shivali"
  };

  // componentDidMount(){
  //   axios.get('').then(res)
  // }

  handleChange = event => {
    this.setState({ name: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    const user = {
      username: "hello",
      firstName: "shiv",
      lastName: "Jejurkar",
      emailId: "null"
    };

    const jsonobj = JSON.stringify(user);
    // const params = new URLSearchParams();
    // params.append("username", this.state.name);
    // params.append("password", this.state.password);
    //axios.post("/foo", params);

    axios.post("http://localhost:8081/login", { user }).then(res => {
      console.log(res.data);
      if (res.data) {
      }
    });
  };

  render() {
    return (
      <Form className="login-form" onSubmit={this.handleSubmit}>
        <h1>LOGIN PORTAL</h1>
        <FormGroup>
          <Label>name</Label>
          <Input
            type="name"
            placeholder="name"
            name="name"
            onChange={this.handleChange}
          />
        </FormGroup>
        <FormGroup>
          <Label>Password</Label>
          <Input type="password" placeholder="password" />
        </FormGroup>

        {/* <Link to="/Login"> */}
        <Button className="btn-lg btn-dark btn-block" type="submit">
          Login
        </Button>
        {/* </Link> */}

        <div className="text-center pt-3">
          Or continue with your social account
        </div>
        <FacebookLoginButton className="mt-3 mb-3" />
        <Button className="btn-lg btn-dark btn-block">Register</Button>
      </Form>
    );
  }
}

export default Login;
