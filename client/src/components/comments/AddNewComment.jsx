import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import CommentService from "../../services/CommentService";
import BookingService from "../../services/BookingService";

const AddNewComment = () => {

    const navigate = useNavigate();
    const params = useParams();
    const { id } = params;

    const [commentId, setCommentId] = useState("");
    const [bookingId, setBookingId] = useState("");
    const [commentName, setCommentName] = useState("");
    const [commentEmail, setCommentEmail] = useState("");
    const [commentBody, setCommentBody] = useState("");

    const [error, setError] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);

     const toggleModal = () => {
       setIsModalOpen(!isModalOpen);
     };

     const handleSubmit = async (e) => {
       e.preventDefault();
       e.stopPropagation();

       const newComment = {
         commentName,
         commentEmail,
         commentBody,
       };

       CommentService.addNewComment(newComment)
         .then(() => {
           navigate("/bookings");
           toast.success("New Comment added successfully!");
         })
         .catch((error) => {
           setError(error.response.data.message);
         });
     };

     useEffect(() => {
        if (id) {
            const fetchNewCategory = async () => {
              try {
                const response = await CommentService.getCommentsById(id);
                const newComment = response.data;
    
                setCommentName(newComment.commentName);
                setCommentEmail(newComment.commentEmail);
                setCommentBody(newComment.commentBody);
              } catch (error) {
                setError(error.message);
                console.error(error);
              }
            };
    
            fetchNewCategory();
          }
     }, [id]);
     

  return (
    <>
      <div className="grid grid-cols-1 gap-4 md:grid-cols-1">
        <div className="p-5 bg-white border rounded border-black/10 dark:bg-darklight dark:border-darkborder"></div>
      </div>
      <Toaster duration={12000} />
    </>
  );
}

export default AddNewComment