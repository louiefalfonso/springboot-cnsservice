import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import CustomerService from "../../services/CustomerService";

const UpdateCustomer = () => {
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

   const handleSubmit = (e) => {
     e.preventDefault();
     e.stopPropagation();

     const currentCustomer = {
       firstName,
       lastName,
       email,
       phoneNumber,
     };

     CustomerService.updateCustomer(id, currentCustomer)
       .then(() => {
         navigate("/customers");
         toast.success("Update Customer Complete!");
         setIsModalOpen(false);
         window.location.reload();
       })
       .catch((error) => {
         setError(error.response.data.message);
       });
   };

   useEffect(() => {
     const fetchCurrentCustomer = async () => {
       try {
         const response = await CustomerService.getCustomerById(id);
         const update = response.data;

         setFirstName(update.firstName);
         setLastName(update.lastName);
         setEmail(update.email);
         setPhoneNumber(update.phoneNumber);
         
       } catch (error) {
         console.error(error);
       }
     };

     fetchCurrentCustomer();
   }, [id]);
  

  return (
    <>
      <div className="grid grid-cols-1 gap-4 md:grid-cols-1">
        <div className="p-5 bg-white border rounded border-black/10 dark:bg-darklight dark:border-darkborder">
          <form
            onSubmit={handleSubmit}
            onClick={(e) => e.stopPropagation()}
            className="grid grid-cols-1 sm:grid-cols-2 gap-4"
          >
            <div className="sm:col-span-1">
              <label
                htmlFor="firstName"
                className="block text-sm font-medium text-gray-900"
              >
                First Name:
              </label>
              <input
                placeholder="Firs Name"
                required
                type="text"
                className="form-input"
                id="firstName"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
              />
            </div>

            <div className="sm:col-span-1">
              <label
                htmlFor="lastName"
                className="block text-sm font-medium text-gray-900"
              >
                Last Name:
              </label>
              <input
                placeholder="Last Name"
                required
                type="text"
                className="form-input"
                id="lastName"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
              />
            </div>

            <div className="sm:col-span-1">
              <label
                htmlFor="email"
                className="block text-sm font-medium text-gray-900"
              >
                Email:
              </label>
              <input
                placeholder="Email"
                required
                type="email"
                className="form-input"
                id="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>

            <div className="sm:col-span-1">
              <label
                htmlFor="phoneNumber"
                className="block text-sm font-medium text-gray-900"
              >
                Phone Number:
              </label>
              <input
                placeholder="Phone Number"
                required
                type="text"
                className="form-input"
                id="phoneNumber"
                value={phoneNumber}
                onChange={(e) => setPhoneNumber(e.target.value)}
              />
            </div>
            <div className="sm:col-span-1">
              <button
                type="submit"
                className="btn w-full py-2 px-4 text-lg bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
              >
                Update Customer
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}

export default UpdateCustomer