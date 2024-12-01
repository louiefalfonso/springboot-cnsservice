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
        <div className="p-5 bg-white border rounded border-black/10 dark:bg-darklight dark:border-darkborder">
          <form
            onSubmit={handleSubmit}
            onClick={(e) => e.stopPropagation()}
            className="grid grid-cols-1 sm:grid-cols-2 gap-4"
          >
            <div className="sm:col-span-1">
              <label
                htmlFor="commentName"
                className="block text-sm font-medium text-gray-900"
              >
                Name:
              </label>
              <input
                placeholder="Name"
                required
                type="text"
                className="form-input"
                id="commentName"
                value={commentName}
                onChange={(e) => setCommentName(e.target.value)}
              />
            </div>
            <div className="sm:col-span-1">
              <label
                htmlFor="commentEmail"
                className="block text-sm font-medium text-gray-900"
              >
                Email:
              </label>
              <input
                placeholder="Email"
                required
                type="email"
                className="form-input"
                id="commentEmail"
                value={commentEmail}
                onChange={(e) => setCommentEmail(e.target.value)}
              />
            </div>
            <div className="sm:col-span-1">
              <label
                htmlFor="commentBody"
                className="block text-sm font-medium text-gray-900"
              >
                Comment Body:
              </label>
              <textarea
                placeholder="Comment Details"
                required
                type="text"
                className="form-input"
                id="commentBody"
                value={commentBody}
                onChange={(e) => setCommentBody(e.target.value)}
                style={{ height: "100px" }}
              />
            </div>
            <div className="sm:col-span-1">
              <button
                type="submit"
                className="btn w-full py-2 px-4 text-lg bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
              >
                Create New Comment
              </button>
            </div>
          </form>
        </div>
      </div>
      <Toaster duration={12000} />
    </>
  );
}

export default AddNewComment