const API_URL = '/api/users';

function addUser() {
    // Collect user data from input fields
    const userData = {
        name: document.getElementById('userName').value,
        email: document.getElementById('userEmail').value,
        role: document.getElementById('userRole').value,
    };

    fetch('/api/users', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(userData),
    })
        .then(response => response.json())
        .then(data => {
            // Update the table dynamically without reloading
            const tableBody = document.getElementById('userTableBody');
            const newRow = document.createElement('tr');
            newRow.innerHTML = `
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.email}</td>
                <td>${data.role}</td>
                <td>
                    <button class="edit-btn" onclick="editUser(${data.id})">Edit</button>
                    <button class="delete-btn" onclick="deleteUser(${data.id})">Delete</button>
                </td>
            `;
            tableBody.appendChild(newRow);
            alert('User added successfully!');
        })
        .catch(error => {
            console.error('Error adding user:', error);
            alert('Failed to add user.');
        });
}


function editUser(user_Id) {
    const updatedData = { name: 'Updated Product', price: 15.99, category: 'Tools' };
    fetch(`${API_URL}/${user_Id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(updatedData),
    }).then(response => response.json()).then(data => {
        alert('Product updated!');
        location.reload();
    });
}

function deleteUser(user_Id) {
    fetch(`${API_URL}/${productId}`, { method: 'DELETE' }).then(() => {
        alert('Product deleted!');
        location.reload();
    });
}
