import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import axios from "axios";
import { toast, Toaster } from "react-hot-toast";
import logo from "../assets/st-lukes-logo-header.svg";
import background from "../assets/medical-background.webp";

const Login = () => {

  const API_BASE_URL = import.meta.env.VITE_BASE_URI_AUTH;
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      if (!email || !password) {
        setError("Please enter both email and password.");
        return;
      }
      const response = await axios.post(`${API_BASE_URL}/login`, {
        email,
        password,
      });
      const { token } = response.data;
      localStorage.setItem("token", token);
      toast.success("Login Successful!");
      window.location.href = "/dashboard";
    } catch (error) {
      setError("Invalid email or password.");
    }
  };

  return (
    <>
      <div
        style={{ backgroundImage: `url(${background})` }}
        className="min-h-screen py-4 px-4 sm:px-12 flex justify-center items-center mx-auto bg-cover bg-center bg-no-repeat"
      >
        <div className="max-w-[550px] flex-none w-full bg-white border border-black/10 p-6 sm:p-10 lg:px-10 lg:py-14 rounded-2xl loginform dark:bg-darklight dark:border-darkborder">
          <img src={logo} className="mx-auto dark-logo h-16 logo" alt="logo" />
          <br />
          <h1 className="mb-2 text-2xl font-semibold text-center dark:text-white">
            Attendant Sign In
          </h1>
          <p className="text-center text-muted dark:text-darkmuted">
            Enter Email and Password to Sign In
          </p>

          <div className="flex items-center mb-7"></div>
          <form className="space-y-4" onSubmit={handleLogin}>
            <div>
              <input
                type="email"
                className="form-input"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                placeholder="Enter Email"
              />
            </div>
            <div>
              <input
                type="password"
                className="form-input"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"
              />
            </div>
            {error && <div className="text-red-500 text-center">{error}</div>}
            <button
              type="submit"
              className="btn w-full py-3.5 text-base bg-info border border-info rounded-md text-white transition-all duration-300 hover:bg-info/[0.85] hover:border-info/[0.85]"
            >
              Sign In
            </button>
          </form>
          <p className="mt-5 text-center text-muted dark:text-darkmuted">
            Not an Employee yet?{" "}
            <Link to="/signup" className="text-blue-500 dark:text-white">
              Create an Account
            </Link>
          </p>
        </div>
      </div>
      <Toaster />
    </>
  );
}

export default Login