import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import CustomerService from "../../services/CustomerService";

const AddNewCustomer = () => {
   const navigate = useNavigate();
   const params = useParams();
   const { id } = params;

   const [firstName, setFirstName] = useState("");
   const [lastName, setLastName] = useState("");
   const [email, setEmail] = useState("");
   const [phoneNumber, setPhoneNumber] = useState("");

   const [error, setError] = useState(null);
   const [isModalOpen, setIsModalOpen] = useState(false);

   const toggleModal = () => {
     setIsModalOpen(!isModalOpen);
   };

   const handleSubmit = async (e) => {
     e.preventDefault();
     e.stopPropagation();
 
     const newCustomer = {
       firstName,
       lastName,
       email,
       phoneNumber,
     };
 
     CustomerService.addNewCustomer(newCustomer)
       .then(() => {
         navigate("/customers");
         toast.success("New Customer added successfully!");
       })
       .catch((error) => {
         setError(error.message);
         console.error(error);
       });
   };
   
   


  return (
    <div>AddCustomers</div>
  )
}

export default AddNewCustomer