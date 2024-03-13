import SwiftUI

struct PasswordTextField: View {
	@Binding var text: String
	@State var showPassword: Bool = false
	
	var body: some View {
		HStack {
			Image(systemName: "lock.fill")
				.foregroundColor(Color.black)
				.padding(.leading, 12.5)
			
			if (showPassword) {
				TextField("Password", text: $text)
					.padding(.horizontal, 12.5)
					.padding(.vertical, 15)
					.textContentType(.password)
					.autocapitalization(.none)
					.disableAutocorrection(true)
			} else {
				SecureField("Password", text: $text)
					.padding(.horizontal, 12.5)
					.padding(.vertical, 15)
					.textContentType(.password)
					.autocapitalization(.none)
					.disableAutocorrection(true)
			}
			
			Image(systemName: showPassword ? "eye.slash.fill" : "eye.fill")
				.padding(.horizontal, 10)
				.onTapGesture {
					showPassword.toggle()
				}
		}
		.background(Color.clear)
		.cornerRadius(5.0)
		.frame(height: 30)
		.padding(.horizontal, 30)
		.padding(.vertical, 10)
	}
}

#Preview {
	@State var text: String = "test123"
	
	return PasswordTextField(text: $text)
}
