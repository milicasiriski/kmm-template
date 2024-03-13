import SwiftUI

struct EmailTextField: View {
	@Binding var text: String
	@State var showPassword: Bool = false
	
	var body: some View {
		HStack {
			Image(systemName: "envelope.fill")
				.foregroundColor(Color.black)
				.padding(.leading, 10)
			
			TextField(
				"Email",
				text: $text
			)
			.keyboardType(.emailAddress)
			.autocapitalization(.none)
			.disableAutocorrection(true)
			.padding(.horizontal, 10)
			.frame(maxWidth: .infinity)
		}
		.background(Color.clear)
		.cornerRadius(5.0)
		.frame(height: 30)
		.padding(.horizontal, 30)
		.padding(.vertical, 10)
	}
}

#Preview {
	@State var text: String = "test123@email.com"
	
	return EmailTextField(text: $text)
}
