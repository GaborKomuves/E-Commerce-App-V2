document.addEventListener("DOMContentLoaded", () => {
    const cartTableBody = document.getElementById("cart-items");
    const cartTotalElement = document.getElementById("cart-total");
    const addItemButton = document.getElementById("add-item-button");
    const addItemModal = document.getElementById("add-item-modal");
    const closeModal = document.querySelector(".close");
    const addItemForm = document.getElementById("add-item-form");

    const API_BASE_URL = "http://localhost:8080/api/cart";

    const fetchCartItems = async () => {
        try {
            const response = await fetch(`${API_BASE_URL}/items`);
            const data = await response.json();
            renderCartItems(data);
            calculateTotal(data);
        } catch (error) {
            console.error("Error fetching cart items:", error);
        }
    };

    const renderCartItems = (items) => {
        cartTableBody.innerHTML = "";
        items.forEach((item) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${item.product.name}</td>
                <td>${item.quantity}</td>
                <td>£${item.totalPrice.toFixed(2)}</td>
                <td>
                    <button onclick="deleteCartItem(${item.id})" class="primary-button">Delete</button>
                </td>
            `;
            cartTableBody.appendChild(row);
        });
    };

    const calculateTotal = (items) => {
        const total = items.reduce((sum, item) => sum + item.totalPrice, 0);
        cartTotalElement.textContent = `Total: £${total.toFixed(2)}`;
    };

    window.deleteCartItem = async (id) => {
        try {
            await fetch(`${API_BASE_URL}/delete/${id}`, { method: "DELETE" });
            fetchCartItems();
        } catch (error) {
            console.error("Error deleting cart item:", error);
        }
    };

    addItemButton.addEventListener("click", () => {
        addItemModal.style.display = "flex";
    });

    closeModal.addEventListener("click", () => {
        addItemModal.style.display = "none";
    });

    addItemForm.addEventListener("submit", async (event) => {
        event.preventDefault();
        const product = document.getElementById("product").value;
        const quantity = document.getElementById("quantity").value;

        try {
            await fetch(`${API_BASE_URL}/add`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ productId: product, quantity }),
            });
            fetchCartItems();
            addItemModal.style.display = "none";
            addItemForm.reset();
        } catch (error) {
            console.error("Error adding cart item:", error);
        }
    });

    fetchCartItems();
});
