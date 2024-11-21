import React, { useState, useEffect } from "react";
import Modal from "../layout/Modal";
import { createPortal } from "react-dom";
import { Toaster } from "react-hot-toast";
import CustomerService from "../../services/CustomerService";
import AddNewCustomer from "./AddNewCustomer";
import UpdateCustomer from "./UpdateCustomer";
import DeleteCustomer from "./DeleteCustomer";

const Customers = () => {
    const [customers, setCustomers] = useState([]);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [error, setError] = useState(null);

    const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false);
    const [isUpdateModalOpen, setIsUpdateModalOpen] = useState(false);

    const toggleModal = () => { setIsModalOpen(!isModalOpen); };
    const toggleDeleteModal = () => { setIsDeleteModalOpen(!isDeleteModalOpen);};
    const toggleUpdateModal = () => { setIsUpdateModalOpen(!isUpdateModalOpen);};


    useEffect(() => {
      const fetchCustomers = async () => {
        const response = await CustomerService.getAllCustomers();
        setCustomers(response.data);
      };
      fetchCustomers();
    }, []);


  return (
    <>
      <div className="flex flex-col gap-4 min-h-[calc(100vh-212px)]">
        <div className="grid grid-cols-1 gap-4">
          <div className="p-5 bg-white border rounded border-black/10 dark:bg-darklight dark:border-darkborder">
            <div className="flex items-center justify-between">
              <h2 className="font-bold">Customer List</h2>
              <button
                type="button"
                onClick={toggleModal}
                className="btn py-1 px-3.5 text-xs bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
              >
                + Add New Customer
              </button>
            </div>
            <div className="overflow-auto">
              <table className="min-w-[640px] w-full mt-4 table-striped">
                <thead>
                  <tr className="ltr:text-left rtl:text-right">
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody className="text-center">
                  {customers.map((customer, index) => (
                    <tr
                      key={customer._id || index}
                      className="ltr:text-left rtl:text-right"
                    >
                      <td>{customer.firstName}</td>
                      <td>{customer.lastName}</td>
                      <td>{customer.email}</td>
                      <td>{customer.phone}</td>
                      <td>
                        <button
                          type="button"
                          onClick={() => toggleUpdateModal(customer._id)}
                          className="btn py-1 px-3.5 text-xs bg-info border border-info rounded-md text-black transition-all duration-300 hover:bg-info/[0.85] hover:border-info/[0.85]"
                        >
                          Update
                        </button>
                        <button
                          type="button"
                          onClick={() => toggleDeleteModal(customer._id)}
                          className="btn py-1 px-3.5 text-xs bg-error border border-error rounded-md text-black transition-all duration-300 hover:bg-error/[0.85] hover:border-error/[0.85]"
                        >
                          Delete
                        </button>
                      </td>
 
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Customers