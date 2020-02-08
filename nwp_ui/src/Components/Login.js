import React from "react";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";

import { FacebookLoginButton } from "react-social-login-buttons";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import axios from "axios";

class Login extends React.Component {
  state = {
    name: "Shivali",
    password: "123"
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
      name: this.state.name,
      password: "shiv"
    };

    const jsonobj = JSON.stringify(user);

    axios.post("http://localhost:8081/login", { user }).then(res => {
      console.log(res);
      console.log(res);
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
